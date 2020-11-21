package kr.hs.emirim.s2019s33.mirimjisik;

import android.graphics.drawable.Drawable;

public class QuestionList {
    private Drawable drawable;
    private String sol;
    private String title;

    //생성자메소드
    public QuestionList(Drawable drawable, String sol, String title){
        this.drawable = drawable;
        this.sol = sol;
        this.title = title;
    }

    //getter & setter
    public Drawable getDrawable(){
        return this.drawable;
    }
    public String getSol(){
        return this.sol;
    }
    public String getTitle(){return this.title; }

    public void setDrawable(Drawable drawable){
        this.drawable = drawable;
    }
    public void setSol(String sol){
        this.sol = sol;
    }
    public void setTitle(String title){ this.title = title; }
}
