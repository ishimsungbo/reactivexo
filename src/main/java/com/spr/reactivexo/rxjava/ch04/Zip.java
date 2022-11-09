package com.spr.reactivexo.rxjava.ch04;

import com.spr.reactivexo.rxjava.Log;
import com.spr.reactivexo.rxjava.Shape;
import io.reactivex.rxjava3.core.Observable;

public class Zip {
    public static void main(String[] args) {

        String[] shapes = {"BALL","PENTAGON","STAR"};
        String[] coloredTriangles = {"2-T","6-T","4-T"};

        Observable<String> source = Observable.zip(
                Observable.fromArray(shapes).map(Shape::getSuffix), //모양을 가져온다
                Observable.fromArray(coloredTriangles).map(Shape::getColor),  //색상을 가져온다
                (suffix, color) -> color + suffix);
        source.subscribe(Log::i);

    }

}
