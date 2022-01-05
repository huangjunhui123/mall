package com.macro.mall.demo.demo.test;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author huangjunhui
 */
@Slf4j
public class RemoveAllTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> mapIds = new HashMap<>();
        List<String> advIdsOne = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("100");
        list.add("101");
        list.add("102");
        list.add("103");
        String ids = "100,101,103";
        List<String> platIds = new ArrayList<>(Arrays.asList(ids.split(",")));
        map.put("e1485da1c9e743a0955be143e5702537","100,102");
        map.put("f8a514f4a9584019a5afec4aeec73fa9","100,103");
        map.put("f72b353432464067ae047e57aafa8b45","102");
        map.forEach((key, obj) -> {
            List<String> list1 = new ArrayList<>(list);
            List<String> plat = new ArrayList<>(platIds);
            List<String> advIds = new ArrayList<>(Arrays.asList(obj.split(",")));
            list1.removeAll(advIds); // 获取该线索未同步的平台

            if (advIds.containsAll(list)) {
                log.info("=============================== 已同步线索无需同步 ===============================");
                System.out.println("已同步线索无需同步{} 线索id：key" + key);
                return;
            }


            log.info("=============================== 线索信息 ===============================");
            System.out.println("该线索未同步的平台：list1" + list1);
            System.out.println("线索id：key" + key);
            System.out.println("该线索已同步的平台：obj" + advIds);
//            System.out.println("分析结果为containsAll：" + platIds.containsAll(list1));


            log.info("=============================== 已完成同步 ===============================");
            if (platIds.containsAll(list1)) {
                System.out.println(key + "该任务已同步完成：" + list1);
            }

            // 收集未完成同步线索id
            log.info("=============================== 收集未同步的线索 ===============================");
            plat.removeAll(advIds);
            System.out.println(key + "{}线索id：key" + plat);
            System.out.println();
            System.out.println();

            // 根据不同接收平台同步线索


            // 获取需要更新的接收数据
            plat.add(obj);
            String str = StringUtils.join(plat,",");
            System.out.println("拼接后的字符串为：" + str);
            mapIds.put(key,str);
            System.out.println("最终结果为：" + mapIds);
            advIdsOne.add(key);// 获取需要更新的线索id
        });



    }

}
