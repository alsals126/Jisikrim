package kr.hs.emirim.s2019s33.mirimjisik;

import android.graphics.drawable.Drawable;

public class QuestionList {
    private Drawable drawable;
    private String name1;
    private String name2;

//    //생성자메소드
//    public QuestionList(String name1, String name2){
//        this.name1 = name1;
//        this.name2 = name2;
//    }

    //getter & setter
    public Drawable getDrawable(){
        return this.drawable;
    }
    public String getName1(){
        return this.name1;
    }
    public String getName2(){
        return this.name2;
    }
    public void setDrawable(Drawable drawable){
        this.drawable = drawable;
    }
    public void setName1(String title){
        this.name1 = name1;
    }
    public void setName2(String desc){
        this.name2 = name2;
    }
}
