import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
  static class sInfo{
    int a,b;
    public sInfo(int a, int b){
      this.a = a;
      this.b = b;
    }
    @Override
    public boolean equals(Object o){
      if (this == o)
        return true;
      if (!(o instanceof sInfo))
        return false;
      sInfo si = (sInfo)o;
      return a == si.a && b == si.b;
    }
    @Override
    public int hashCode() {
      return Objects.hash(a, b);
    }
  };

  static class Info implements Comparable<Info>{
    int a,b,val;
    public Info(int a, int b, int val){
      this.a = a;
      this.b = b;
      this.val = val;
    }
    @Override
    public int compareTo(Info o){
      return Integer.compare(this.val,o.val);
    }
  };

  public static void main (String[] args) throws java.lang.Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String ss = br.readLine();
    StringTokenizer st = new StringTokenizer(ss);
    int fa=0,fb=0,ta=0,tb=0,result=-1;
    fa = Integer.parseInt(st.nextToken());
    fb = Integer.parseInt(st.nextToken());
    ta = Integer.parseInt(st.nextToken());
    tb = Integer.parseInt(st.nextToken());

    HashSet<sInfo> s = new HashSet<>();
    PriorityQueue<Info> pq = new PriorityQueue<>();
    s.add(new sInfo(0,0));
    pq.add(new Info(0,0,0));
    while(!pq.isEmpty()){
      Info ii = pq.poll();
      int ca = ii.a;
      int cb = ii.b;
      int cv = ii.val;
      if(ca==ta && cb==tb){
        result=cv;
        break;
      }
      //a 비우기
      if(!s.contains(new sInfo(0,cb))){
        s.add(new sInfo(0,cb));
        pq.add(new Info(0,cb,cv+1));
      }
      //b 비우기
      if(!s.contains(new sInfo(ca,0))){
        s.add(new sInfo(ca,0));
        pq.add(new Info(ca,0,cv+1));
      }
      //a 채우기
      if(!s.contains(new sInfo(fa,cb))){
        s.add(new sInfo(fa,cb));
        pq.add(new Info(fa,cb,cv+1));
      }
      //b 채우기
      if(!s.contains(new sInfo(ca,fb))){
        s.add(new sInfo(ca,fb));
        pq.add(new Info(ca,fb,cv+1));
      }
      int remainA = fa-ca;
      int remainB = fb-cb;

      //a->b
      if(ca>remainB && !s.contains(new sInfo(ca-remainB,fb))){
        s.add(new sInfo(ca-remainB,fb));
        pq.add(new Info(ca-remainB,fb,cv+1));
      }
      else if(ca<=remainB && !s.contains(new sInfo(0,cb+ca))){
        s.add(new sInfo(0,cb+ca));
        pq.add(new Info(0,cb+ca,cv+1));
      }
      //b->a
      if(cb>remainA && !s.contains(new sInfo(fa,cb-remainA))){
        s.add(new sInfo(fa,cb-remainA));
        pq.add(new Info(fa,cb-remainA,cv+1));
      }
      else if(cb<=remainA && !s.contains(new sInfo(ca+cb,0))){
        s.add(new sInfo(ca+cb,0));
        pq.add(new Info(ca+cb,0,cv+1));
      }
    }
    System.out.print(result);
  }
}