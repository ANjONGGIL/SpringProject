package kr.co.fastcampus.cli.di;

public class B {
    boolean condition;

    public B(boolean condition){
        this.condition = condition;
    }

    public int calc(){
        if (condition){
            return 1;
        }else{
            return 0;
        }

    }
}
