package com.abdts.common.util;

import com.alibaba.druid.proxy.jdbc.ClobProxyImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.Reader;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

/**
 * 自定义数据传输 Map
 * @author zy
 */
public final class DataKeyPair extends HashMap implements Map {

    private static final Logger log = LoggerFactory.getLogger(DataKeyPair.class);

    private static final long serialVersionUID = 1L;

    /** 数据 Map */
    private Map<String,Object> map = null;

    /** request 实例 */
    private HttpServletRequest request;

    /**
     * 构建空的 DataKeyPair
     */
    public DataKeyPair() {}

    /**
     * 构建解析参数的 DataKeyPair
     * @param request
     */
    public DataKeyPair(HttpServletRequest request) {
        this.request = request;
        initial();
    }

    /**
     * 解析 parameterMap
     * 改变 parameterMap 键值对形式
     * 原: String,String[]
     * 改变后:String,String
     */
    private void initial() {
        // 从 request 取出 Map
        Map<String, String[]> propertiesMap = request.getParameterMap();
        // 参数 Map 不为空
        if (propertiesMap.size() > 0) {
            // 中间 Map 参数全部添加到 returnMap 后
            // 全局 map.putAll(returnMap)
            Map<String,Object> returnMap = new HashMap<>();
            // 迭代器
            Iterator<Entry<String, String[]>> entries = propertiesMap.entrySet().iterator();
            // 单个对象
            Entry<String,String[]> entry;
            // key
            String key;
            // value
            String value = "";
            // 迭代 entries 条件为 是否又下一个
            while (entries.hasNext()) {
                // 获取当前 entries 的 entry
                entry = entries.next();
                // 获取 key
                key = entry.getKey();
                // 获取 value
                Object valueObj = entry.getValue();
                // value为空
                if (null == valueObj) {
                    // String 类型 ""
                    value = "";
                // value 是String[]
                } else if (valueObj instanceof String[]) {
                    // 将 Object 转换为String[]
                    String[] values = (String[]) valueObj;
                    // 例 name=[张三,李四] 改变后 value:张三,李四
                    for (int i = 0; i < values.length; i++) {
                        value = values[i] + ",";
                    }
                    // 截去最后的 ,
                    value = value.substring(0,value.length() - 1);
                // String 类型
                } else {
                    value = valueObj.toString();
                }
                // 添加 key,value 到 returnMap
                returnMap.put(key,value);
            }
            // 将 returnMap 添加到 map
            map = returnMap;
        } else {
        	map = new HashMap<>();
        }
    }

    /**
     * 添加键值对
     * @param key key
     * @param value value
     * @return
     */
    @Override
    public Object put(final Object key, Object value) {
        //读取oracle Clob类型数据
        if(value instanceof ClobProxyImpl){
            try {
                ClobProxyImpl cpi = (ClobProxyImpl)value;
                //获取流
                Reader is = cpi.getCharacterStream();
                BufferedReader br = new BufferedReader(is);
                String str = br.readLine();
                StringBuffer sb = new StringBuffer();
                //循环读取数据拼接到字符串
                while(str != null){
                    sb.append(str);
                    sb.append("\n");
                    str = br.readLine();
                }
                value = sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map.put((String) key, value);
    }

    /**
     * 根据 key 获取 value
     * @param key
     * @return
     */
    @Override
    public Object get(final Object key) {
        Object obj;
        if (map.get(key) instanceof Object[]) {
            Object[] arr = (Object[]) map.get(key);
            // 从 request 中获取 value
            String requestValue = request.getParameter((String) key);
            // request 为空 obj = arr 否则如果 request 中的 value 为空 obj = arr : arr[0]
            obj = null == request ? arr : null == requestValue ? arr : arr[0];
        } else {
            obj = map.get(key);
        }
        return obj;
    }

    /**
     * 获取 String 类型 的 value
     * @param key
     * @return
     */
    public String getString(final String key) {
        return (String) get(key);
    }

    /**
     * 获取 Integer 类型的 value
     * @param key key
     * @return value
     */
    public Integer getInt(final String key) {
        return Integer.parseInt(getString(key));
    }

    /**
     * 格式化 Date 类型数据为 String
     * @param key map key
     * @param hh 包含 H || h 格式化为 2000-22-22 22:22:22
     *           不包含 格式化为 2000-22-22
     * @return 格式化后的数据
     */
    public String getDateFormatString(final String key,final String hh) {
        String format;
        // 包含 H || h
        if (hh.contains("h") || hh.contains("H")) {
            format = DateUtil.formatYMDHMS((Date) get(key));
        } else {
            format = DateUtil.formatYMD((Date) get(key));
        }
        return format;
    }

    /**
     * 获取 Double 类型的 value
     * @param key key
     * @return value
     */
    public Double getDouble(final String key) {
        return Double.parseDouble(getString(key));
    }

    /**
     * 根据 key 删除键值
     * @param key key
     * @return 删除前的值
     *         状态为已删除 瞬时
     */
    @Override
    public Object remove(final Object key) {
        return map.remove(key);
    }

    /**
     * 清空 map
     */
    @Override
    public void clear() {
        map.clear();
    }

    /**
     * map 中是否存在 key
     * @param key key
     * @return true 存在
     *         false 不存在
     */
    @Override
    public boolean containsKey(final Object key) {
        return map.containsKey(key);
    }

    /**
     * map 中是否存在 value
     * @param value value
     * @return true 存在
     *         false 不存在
     */
    @Override
    public boolean containsValue(final Object value) {
        return map.containsValue(value);
    }

    /**
     * map 是空
     * @return true 空
     *         false 不空
     */
    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * 获取 key 的有序列表
     * @return key 的有序列表
     */
    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    /**
     * 获取 map 有序集合
     * @return 有序集合
     */
    @Override
    public Set<Entry<String, Object>> entrySet() {
        return map.entrySet();
    }

    /**
     * map 长度
     * @return map 长度
     */
    @Override
    public int size() {
        return map.size();
    }

    /**
     * 添加一个 Map
     * @param m
     */
    @Override
    public void putAll(final Map m) {
        map.putAll(m);
    }

    /**
     * 获取 map value的列表
     * @return value的列表
     */
    @Override
    public Collection values() {
        return map.values();
    }

    public static void main(String[] args) {
        DataKeyPair dkp = new DataKeyPair();
        dkp.put("x1","56");
        dkp.put("x2", "2016-1-2");
        dkp.put("x3", "2016-1-2 11:22:33");
        dkp.put("x4", DateUtil.parse(DateUtil.formatYMD(new Date())));
        dkp.put("x5", "57");
        dkp.put("x6", "张三");
        dkp.put("x7", 15);
        System.out.println(dkp.getDouble("x1"));
        System.out.println(dkp.getDateFormatString("x4",""));
        System.out.println(dkp.getString("x6"));
        System.out.println(dkp.getDouble("x1"));
        System.out.println(dkp.getInt("x5"));
        System.out.println(dkp.values());
        System.out.println(dkp.keySet());
        System.out.println(dkp.containsKey("x1"));
        System.out.println(dkp.containsValue(15));
        System.out.println(dkp.isEmpty());
        dkp.clear();
        System.out.println(dkp.isEmpty());
        System.out.println(dkp.entrySet());
        System.out.println(dkp.size());
    }

}
