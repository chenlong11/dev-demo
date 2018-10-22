package cn.ksource.util;

import cn.hutool.core.convert.Convert;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.map.LinkedMap;

import java.util.*;

/**
 * 多叉树类
 */
@Slf4j
public class TreeUtil {

	public static <T> List<Map> createTreeByList(List<T> dataList){
		Map root = new HashMap();
		List list = new ArrayList<Map>();
		root.put("children", list);
		if(dataList==null || dataList.size()<=0){
			return new ArrayList<Map>();
		}

		LinkedHashMap<String,Map> dataMap = new LinkedHashMap<String,Map>();
		//将数据LIST放置到MAP中
		for(T obj:dataList){
			Map map = new LinkedMap();
			if(obj instanceof Map){
				map = (Map) obj;
			} else {
				map = ConvertSupport.object2map(obj);
			}
			dataMap.put(Convert.toStr(map.get("id")),map);
		}

		//组装树
		for(String key:dataMap.keySet()){
			String pid = Convert.toStr((((Map) dataMap.get(key)).get("pid")));
			if(pid.equals("-1")||dataMap.get(pid)==null){
				((List<Map>)root.get("children")).add((Map)dataMap.get(key));
			}else{
				Map parentNode = (Map)dataMap.get(pid);
				if(parentNode!=null){
					if(parentNode.get("children")==null){
						List children = new ArrayList<Map>();
						parentNode.put("children", children);
					}
					((List<Map>)parentNode.get("children")).add((Map)dataMap.get(key));
				}
			}
		}

		if(root.get("children")!=null){
			return (List<Map>)root.get("children");
		}else{
			return new ArrayList<Map>();
		}
	}
	
}