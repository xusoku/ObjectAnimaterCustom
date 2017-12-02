package com.davis.objectanimatercustom;

import java.util.ArrayList;

/**
 * Created by xushengfu on 2017/12/2.
 */

public class AnimatorPath {
    ArrayList<PathPoint> mPoints=new ArrayList<>();

    public  void lineTo(float x,float y){
        mPoints.add(PathPoint.lineTo(x,y));
    }
    public  void curveTo(float c0x,float c0y,float c1x,float c1y,float x,float y){
        mPoints.add(PathPoint.curveTo(c0x,c0y,c1x,c1y,x,y));
    }
    public  void moveTo(float x,float y){
        mPoints.add(PathPoint.moveTo(x,y));
    }

    public ArrayList<PathPoint> getmPoints() {
        return mPoints;
    }
}
