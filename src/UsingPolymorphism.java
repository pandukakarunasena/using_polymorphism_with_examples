import java.util.*;

class ControlRoom2{
    private WaterLevelObserver[] observerArray=new WaterLevelObserver[100];
    private int waterLevel;
    private int nextIndex;

    public void addWaterLevelObserver(WaterLevelObserver observer){
        observerArray[nextIndex++]=observer;
    }

    private void notifyObjects(){
        for(int i=0; i<nextIndex; i++){
            observerArray[i].update(waterLevel);
        }
    }

    public void setWaterLevel(int waterLevel){
        if(this.waterLevel!=waterLevel){
            this.waterLevel=waterLevel;
            notifyObjects();
        }
    }
}

class Demo2{
    public static void main(String args[]){
        ControlRoom2 controlRoom=new ControlRoom2();
        controlRoom.addWaterLevelObserver(new Alarm(001));
        controlRoom.addWaterLevelObserver(new SMSSender());
        controlRoom.addWaterLevelObserver(new Display());
        controlRoom.addWaterLevelObserver(new Splitter());

        Random r=new Random();
        while(true){
            int rand=r.nextInt(101); //0 to 100
            controlRoom.setWaterLevel(rand);
            try{Thread.sleep(1000);}catch(Exception ex){}
        }
    }
}

