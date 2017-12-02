package com.davis.objectanimatercustom;

import android.animation.TypeEvaluator;

/**
 * Created by xushengfu on 2017/12/2.
 */

public class PathEvaluator implements TypeEvaluator<PathPoint> {
    @Override
    public PathPoint evaluate(float fraction, PathPoint startValue, PathPoint endValue) {
//        fraction执行的百分比0～1
        float x=0,y=0;

        if(endValue.mOperation==PathPoint.CURVE){
            float oneMinusT=1-fraction;

            x = oneMinusT * oneMinusT * oneMinusT * startValue.mX +
                    3 * oneMinusT * oneMinusT * fraction * endValue.mControl0X +
                    3 * oneMinusT * fraction * fraction * endValue.mControl1X +
                    fraction * fraction * fraction * endValue.mX;

            y = oneMinusT * oneMinusT * oneMinusT * startValue.mY +
                    3 * oneMinusT * oneMinusT * fraction * endValue.mControl0Y +
                    3 * oneMinusT * fraction * fraction * endValue.mControl1Y +
                    fraction * fraction * fraction * endValue.mY;

        }else if(endValue.mOperation==PathPoint.LINE){
            //x=起始点+fraction*（起始点和终点的距离）
            x=startValue.mX+fraction*(endValue.mX-startValue.mX);
            y=startValue.mY+fraction*(endValue.mY-startValue.mY);

        }else if(endValue.mOperation==PathPoint.MOVE){
            x=endValue.mX;
            y=endValue.mY;
        }

        return PathPoint.moveTo(x,y);
    }
}
