package sample;

import java.util.ArrayList;
import java.util.Observable;

class Model extends Observable{
    private int height;
    private int width;

    private ArrayList<ArrayList<Integer>> value;

    public void setHeight(int h){
        while (height < h){
            value.add(new ArrayList<Integer>(width));
            height++;
        }
        while (height > h){
            value.remove(height - 1);
            height--;
        }
        this.setChanged();
        this.notifyObservers();
    }

    public void setWidth (int w){
        for(int i = 0; i < height; i++){
            ArrayList<Integer> current = value.get(i);
            int currentWidth = width;
            while(currentWidth < w){
                current.add(0);
            }
            while (currentWidth > w){
                current.remove(currentWidth - 1);
            }
        }
        width = w;
        this.setChanged();
        this.notifyObservers();
    }

    public void setValue (String s, int i, int j){
        int val;
        try {
            val = Integer.parseInt(s.trim());
        } catch(Exception e){
            val = getValue(i, j);
        }
        setValue(val, i, j);
    }

    public void setValue(int val, int i, int j){
        value.get(i - 1).set(j - 1, val);
        this.setChanged();
        this.notifyObservers();
    }


    public int getValue(int i, int j){
        return value.get(i - 1). get(j - 1);
    }
}
