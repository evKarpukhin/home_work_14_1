package ru.skypro;


import ru.skypro.exception.BadIndexException;
import ru.skypro.exception.BadValueException;
import ru.skypro.exception.NotFountValueException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    final String[] strArray;
    private int size = 0; // кол-во элементов в массиве

    public StringListImpl(int size) {
        this.strArray = new String[size];
    }

    @Override
    public String add(String item) {
        if (item == null || size >= strArray.length) {
            throw new BadValueException("Bad value array." + item);
        }
        return strArray[size++] = item;
    }

    @Override
    public String add(int index, String item) {
        if (index > size || index > strArray.length) {
            throw new BadIndexException("Bad index array " + index);
        }

        for (int i = size; i > index; i--) {
            strArray[i] = strArray[i - 1];
        }
        strArray[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index > size || index > strArray.length) {
            throw new BadIndexException("Bad index array " + index);
        }
        return strArray[index] = item;
    }

    @Override
    public String remove(String item) {
        int ind = 0;
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (strArray[i].equals(item)) {
                ind = i;
                found = true;
                break;
            }
        }
        if (!found) {
            throw new NotFountValueException("Value not found.");
        }
        if (ind == size - 1) {
            strArray[ind] = null;
        } else {
            for (int i1 = ind; i1 < size - 1; i1++) {
                strArray[i1] = strArray[i1 + 1];
            }
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        if (index > size || index > strArray.length) {
            throw new BadIndexException("Bad index array " + index);
        }
        String str = strArray[index];
        if (index == size - 1) {
            strArray[index] = null;
        } else {
            for (int i1 = index; i1 < size - 1; i1++) {
                strArray[i1] = strArray[i1 + 1];
            }
        }
        size--;
        return str;
    }

    @Override
    public boolean contains(String item) {
        for (String s : strArray) {
            if (s.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (strArray[i].contains(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size; i == 0; i--) {
            if (strArray[i].contains(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > size) {
            throw new BadIndexException("Bad index array.");
        }
        return strArray[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == this) {
            return true;
        }

        if (!(otherList instanceof StringList)) {
            return false;
        }

        String[] strOtherList = ((StringListImpl)otherList).strArray;
        return Arrays.equals(strArray, strOtherList);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(strArray, null);
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(strArray, size);
    }
}
