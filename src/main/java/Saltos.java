public class Saltos {

    HojaCercana hojaCercana;

    public Saltos(HojaCercana hojaCercana){

        this.hojaCercana = hojaCercana;

    }

    public int momentoDeSaltar(int []A){

        int hojaEnLaQueSalto = -1;

        for(int i = 0; i<=A.length-1; i++){
            if(this.hojaCercana.hojaMasCercana(A[i])){
                hojaEnLaQueSalto = i;
                return hojaEnLaQueSalto;
            }
        }
        return hojaEnLaQueSalto;
    }
}

