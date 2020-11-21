package kr.hs.emirim.s2019s33.mirimjisik;

public class chatitem {
    private String name;
    private String text;

    //생성자메소드
    public chatitem(String name, String text){
        this.name = name;
        this.text = text;
    }

    //getter & setter
    public String getName(){
        return this.name;
    }
    public String getText(){
        System.out.print("get" + this.text);return this.text;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setText(String desc){
        System.out.print("set" + this.text);
        this.text = text;
    }
}
