package com.fjhckj.springcloudtest.utils;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 * Created by admin on 2019/1/4.
 */
public class PropertiesUtils {
    private static String PROPERTY_NAME = "application.yml";

    public static Object getCommonYml(Object key){
        Resource resource = new ClassPathResource(PROPERTY_NAME);
        Properties properties = null;
        try {
            YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
            yamlFactory.setResources(resource);
            properties =  yamlFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return properties.get(key);
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] resultArr = {-1,-1};
        //利用二分查找查找出目标的索引
        int head = 0;
        int last = nums.length-1;
        boolean flag = false;
        while(last>=head){
            int mid = (head+last)/2;
            if(nums[mid]==target){
                head = mid;
                last = mid;
                flag = true;
                break;
            }else if (nums[mid]>target){
                last = mid-1;
            }else if (nums[mid]<target){
                head = mid+1;
            }
        }
        //如果找到目标值
        if(flag){
            //向前遍历，查看前一个数是否相同
            while ( head!=0&&target == nums[head-1] ) head--;
            while (last!=nums.length-1&&nums[last]==nums[last+1]) last++;
            resultArr[0] = head;
            resultArr[1] = last;
        }
        return resultArr;

    }



    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{5,7,7,8,8,10},8).toString());
    }
}
