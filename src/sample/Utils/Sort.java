package sample.Utils;

public class Sort {

    //functia de sortare descrescatoare a unei liste de tupluri
    //bubble sort
    public Pair<String ,Integer>[] sortDesc(Pair<String ,Integer>[] list){
        int n = list.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (list[j+1].y>list[j].y)    //cand gasim un element mai mic decat urmatorul le interschimbam
                {
                    Pair<String,Integer> aux = list[j];
                    list[j]=list[j+1];
                    list[j+1]=aux;
                }
        return list;
    }
}
