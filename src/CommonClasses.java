abstract class WaterLevelObserver{
    abstract void update(int waterLevel);
}

class Alarm extends WaterLevelObserver{
    private int id;

    //naming the equipments to further procedures. this can be removed if naming a equipment is not needed.
    Alarm(int id){
        this.id = id;
    }

    private String  name;
    Alarm(String name){
        this.name=name;
    }

    public void operateAlarm(int waterLevel){
        System.out.println(waterLevel>=50 ? name+" Alarm ON":name+" Alarm OFF");
    }

    public void update(int waterLevel){
        System.out.println(waterLevel>=50 ? " Alarm ON":" Alarm OFF");
    }
}

class Display extends WaterLevelObserver{
    public void update(int waterLevel){
        System.out.println("Water Level : "+waterLevel);
    }

    public void displayWaterLevel(int waterLevel){
        System.out.println("Water Level : "+waterLevel);
    }

}

class SMSSender  extends WaterLevelObserver{
    public void update(int waterLevel){
        System.out.println("Sending Water Level : "+waterLevel);
    }

    public void sendSMS(int waterLevel){
        System.out.println("Sending Water Level : "+waterLevel);
    }
}

class Splitter extends WaterLevelObserver{
    public void update(int waterLevel){
        System.out.println(waterLevel>=75 ? "Splitter ON":"Splitter OFF");
    }

    public void split(int waterLevel){
        System.out.println(waterLevel>=75 ? "Splitter ON":"Splitter OFF");
    }

}
