import java.util.Random;

class ControlRoom{
    private Alarm[] alarm=new Alarm[10];
    private int nextIndex=0;
    private Display display;
    private SMSSender smsSender;
    private Splitter splitter;

    private int waterLevel;

    public void addSplitter(Splitter splitter){
        this.splitter=splitter;
    }
    public void addAlarm(Alarm alarm){
        this.alarm[nextIndex++]=alarm;
    }
    public void addDisplay(Display display){
        this.display=display;
    }
    public void addSMSSender(SMSSender smsSender){
        this.smsSender=smsSender;
    }
    private void notifyObjects(){
        //alarm.operateAlarm(waterLevel);
        for(int i=0; i<nextIndex;i++){
            alarm[i].operateAlarm(waterLevel);
        }
        display.displayWaterLevel(waterLevel);
        smsSender.sendSMS(waterLevel);
        splitter.split(waterLevel);
    }
    public void setWaterLevel(int waterLevel){
        if(this.waterLevel!=waterLevel){
            this.waterLevel=waterLevel;
            notifyObjects();
        }
    }
}

class Demo{
    public static void main(String args[]){
        ControlRoom controlRoom=new ControlRoom();
        controlRoom.addAlarm(new Alarm("AOne"));
        controlRoom.addAlarm(new Alarm("ATwo"));
        controlRoom.addAlarm(new Alarm("AThree"));
        controlRoom.addDisplay(new Display("DOne"));
        controlRoom.addSMSSender(new SMSSender("SMSOne"));
        controlRoom.addSplitter(new Splitter("SOne"));
        Random r=new Random();
        while(true){
            int rand=r.nextInt(101); //0 to 100
            controlRoom.setWaterLevel(rand);
            try{Thread.sleep(1000);}catch(Exception ex){}
        }
    }
}

