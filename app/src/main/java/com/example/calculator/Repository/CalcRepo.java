package com.example.calculator.Repository;


import com.example.calculator.entities.Result;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class CalcRepo {

    public Result calculate(String data){
       try {
           Context context = Context.enter();
           context.setOptimizationLevel(-1);
           Scriptable scriptable = context.initSafeStandardObjects();
           String javascript = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
           return new Result(javascript);
       }catch (Exception e){
           return new Result(e.toString());
       }
    }
}
