package nassim.doum.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tread on 08/04/2016.
 */
public class Chariot {
    public List<ElementChariot> produitsChariot = new ArrayList<>();

    public Chariot() {
    }

    public int find(ElementChariot e){
        for(int i=0;i<produitsChariot.size();i++){
            if (produitsChariot.get(i).getProduit().getNomProduit().equals(e.getProduit().getNomProduit())){
                return i;
            }
        }
        return -1;
    }

    public List<ElementChariot> getProduitsChariot() {
        return produitsChariot;
    }

    public void add(ElementChariot element){

        int i = AppData.chariot.find(element);

        if (i < 0){
            AppData.chariot.getProduitsChariot().add(element);
        }else{
            AppData.chariot.getProduitsChariot().get(i).setQuantite(element.getQuantite());

        }
    }

    public void remove(ElementChariot element){
        int i = AppData.chariot.find(element);
        if (i >= 0){
            AppData.chariot.getProduitsChariot().remove(element);
        }
    }

}
