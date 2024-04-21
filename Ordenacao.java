public class Ordenacao {
    public static void selectionSort(Item[] itens) {
        for (int i = 0; i < itens.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < itens.length; j++) {
                if (itens[j].getCategoria().compareTo(itens[minIndex].getCategoria()) < 0) {
                    minIndex = j;
                }
            }
            Item temp = itens[minIndex];
            itens[minIndex] = itens[i];
            itens[i] = temp;
        }
    }

    public static void bubbleSort(Item[] itens) {
        for (int i = 0; i < itens.length - 1; i++) {
            for (int j = 0; j < itens.length - i - 1; j++) {
                if (itens[j].getAvaliacao() < itens[j + 1].getAvaliacao()) {
                    Item temp = itens[j];
                    itens[j] = itens[j + 1];
                    itens[j + 1] = temp;
                }
            }
        }
    }
}
