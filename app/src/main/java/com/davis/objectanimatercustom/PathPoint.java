package com.davis.objectanimatercustom;

import java.util.ArrayList;

/**
 * Created by xushengfu on 2017/12/2.
 */

public class PathPoint  {
    public static final int MOVE=0;
    public static final int LINE=1;
    public static final int CURVE=2;

    float mX,mY;
    float mControl0X,mControl0Y;
    float mControl1X,mControl1Y;
    int mOperation;
    private PathPoint(int mOperation,float x,float y){
        this.mOperation=mOperation;
        this.mX=x;
        this.mY=y;
    }
    private PathPoint(float c0x,float c0y,float c1x,float c1y,float x,float y){
        this.mOperation=CURVE;
        this.mX=x;
        this.mY=y;
        this.mControl0X=c0x;
        this.mControl0Y=c0y;
        this.mControl1X=c1x;
        this.mControl1Y=c1y;
    }

    public static PathPoint lineTo(float x,float y){
        return new PathPoint(LINE,x,y);
    }
    public static PathPoint curveTo(float c0x,float c0y,float c1x,float c1y,float x,float y){
        return  new PathPoint(c0x,c0y,c1x,c1y,x,y);
    }
    public static PathPoint moveTo(float x,float y){
        return new PathPoint(MOVE,x,y);
    }

}
