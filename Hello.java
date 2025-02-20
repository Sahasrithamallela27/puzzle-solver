class Hello{
    public static void main(String args[]){
        double d=5.6;
        int s=(int)d;
        byte b=50;
        byte a=30;
        int result=a*b;

        d=s;
        int nums[]=new int[5];
        System.out.println(nums.length);

    }
}
class A{
    public void show(){
        System.out.println("this is A");
    }
}
class B extends A{
    public void show1(){
        System.out.println("this is B");
    }
}