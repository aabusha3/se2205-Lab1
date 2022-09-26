/*
 * Author: Ahmad Sami Abu Shawarib & Kevin Abdo
 * Student #: 251149713  &  251171763
 * Date:  Oct. 10, 2021
 * Description: The Pair class with getter and setter methods for its two general type private data fields
 */

package LA1Q1;

public class Pair <Y,N> {
    private Y key;//Y type variable to store the students' current years
    private N value;//N type variable to store students' names


    //constructor with Y & N type params; sets private key & values to the params
    public Pair(Y key, N value){//constructor with Y & N type params; sets private key & values to the params
        this.key = key;
        this.value = value;
    }

    //void method with Y type param; sets private key to the param
    public void setKey(Y key) {
        this.key = key;
    }

    //void method with N type param; sets private value to the param
    public void setValue(N value) {
        this.value = value;
    }

    //Y type method; gets private key's value
    public Y getKey() {
        return key;
    }

    //N type method; gets private value's value
    public N getValue() {
        return value;
    }
}
