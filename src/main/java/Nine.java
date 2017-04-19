public class Nine {

    static int[][] nine=new int[3][3];
    static boolean[] used=new boolean[10];

    public static void main(String[] args){

        for(int i=0;i<10;++i){
            used[i]=true;
        }

        dfs(0);

    }

    public static void dfs(int step){
        if(step==9){
            if(check()==true){
                for(int i=0;i<3;++i){
                    for(int j=0;j<3;++j){
                        System.out.print(nine[i][j]+" ");
                    }
                    System.out.println();
                }
                System.out.println("===========");
            }
        }

        for(int i=1;i<=9;++i){
            if(used[i]==true){
                used[i]=false;
                nine[step/3][step%3]=i;
                dfs(step+1);
                used[i]=true;
            }
        }
    }

    public static boolean check(){
        int[] sum_i=new int[3];
        for(int i=0;i<3;++i){
            sum_i[i]=0;
            for(int j=0;j<3;++j){
                sum_i[i]+=nine[i][j];
            }
        }
        if(sum_i[0]!=sum_i[1] || sum_i[1]!=sum_i[2] || sum_i[0]!=sum_i[2]) return false;

        int[] sum_j=new int[3];
        for(int j=0;j<3;++j){
            sum_j[j]=0;
            for(int i=0;i<3;++i){
                sum_j[j]+=nine[i][j];
            }
        }
        if(sum_j[0]!=sum_j[1] || sum_j[1]!=sum_j[2] || sum_j[0]!=sum_j[2]) return false;

        int sum1=nine[0][0]+nine[1][1]+nine[2][2];

        if(sum_i[0]!=sum1) return false;

        int sum2=nine[1][1]+nine[0][2]+nine[2][0];

        if(sum_i[0]!=sum2) return false;

        return true;
    }

}