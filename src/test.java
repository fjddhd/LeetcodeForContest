public class test {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum=0,sum1=0;
        int flag=0;
        if (destination>start){
            flag=0;
        }
        else {
            flag=1;
        }
        for (int i=0;i<distance.length;++i){
            sum+=distance[i];
            if (flag==0){
               if (i>=start && i<destination){
                   sum1+=distance[i];
               }
            }else {
                if (i>=destination && i<start){
                    sum1+=distance[i];
                }
            }
        }
        if (sum1<sum/2){
            return sum1;
        }
        else {
            return sum-sum1;
        }

    }
}
