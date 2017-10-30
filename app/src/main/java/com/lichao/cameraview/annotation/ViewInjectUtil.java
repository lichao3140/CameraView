package com.lichao.cameraview.annotation;

import android.app.Activity;
import java.lang.reflect.Field;

/**
 * View注解工具
 * Created by Administrator on 2017-10-30.
 */

public class ViewInjectUtil {

    private static final String TAG = "ViewInjectUtil";
    public static void injectView(Activity activity){

        try {
            Field[] fields = activity.getClass().getDeclaredFields();       //获取类中声明的字段
            for (Field field : fields) {
                boolean isAnnotationPresent = field.isAnnotationPresent(ViewInject.class);      //字段是否关联注解
                if(isAnnotationPresent){
                    ViewInject viewInject = field.getAnnotation(ViewInject.class);      //获取所关联的注解
                    field.setAccessible(true);
                    field.set(activity,activity.findViewById(viewInject.value()));      //为字段设置findViewById值
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
