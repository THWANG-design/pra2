package com.Meituan;

import com.sun.jdi.Value;

import java.util.*;

public class WangYi {


    public void findMaxResult(String[]username, int[]timeStamp, String[]website){
        Map<String,ArrayList<String>> map = new HashMap<>();
        String name = username[0];
        ArrayList<String>temp = new ArrayList<>();
        temp.add(website[0]);
        for(int i= 1; i < username.length;i++){
            if(!username[i].equals(name)){
                temp = new ArrayList<>();
                name = username[i];
            }
            temp.add(website[i]);
            map.put(name, new ArrayList<>(temp));
        }
        TreeMap<String, Integer>res  = new TreeMap<>();
        List<Map.Entry<String,Integer>> mappingList = null;

        ArrayList<String>tempList = new ArrayList<>();
        Map<String, List<String>>tempMap = new HashMap<>();
        for(String s : map.keySet()){
            ArrayList<String>list = map.get(s);
            parseString(res, list, 0, tempList, 0, tempMap);
        }
        mappingList = new ArrayList<Map.Entry<String,Integer>>(res.entrySet());

        Collections.sort(mappingList, new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> mapping1,Map.Entry<String,Integer> mapping2){
                return mapping1.getValue() - mapping2.getValue() == 0? mapping1.getKey().compareTo(mapping2.getKey()) : mapping2.getValue() - mapping1.getValue();
            }
        });

        Map.Entry<String,Integer> mapping = mappingList.get(0);
        String s = mapping.getKey();
        List<String>r = tempMap.get(s);
        for(int i = 0; i < r.size(); i++){
            System.out.println(r.get(i));
        }
        return;



    }

    public void parseString(TreeMap<String,Integer>map, List<String>list, int index, List<String>tempList, int time,Map<String, List<String>>tempMap){
        if(tempList.size() == 3){
            String s = listToString(tempList);
            tempMap.put(s, new ArrayList<>(tempList));
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }
        for(int i = index; i < list.size(); i++){
            tempList.add(list.get(i));
            parseString(map, list, i + 1, tempList, time + 1,tempMap);
            tempList.remove(tempList.size() - 1);
        }
    }

    public String listToString(List<String>list){
        String res = "";
        for(int i = 0; i < list.size(); i++){
            res += list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String[]username = new String[]{"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[]timeStamp = new int[]{1,2,3,4,5,6,7,8,9,10};
        String[]website = new String[]{"home","about","career","home","cart","maps","home","home","about","career"};
        WangYi s = new WangYi();
        s.findMaxResult(username,timeStamp,website);



    }


}
