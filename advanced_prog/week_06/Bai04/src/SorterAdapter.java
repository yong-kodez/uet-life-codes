public class SorterAdapter implements Sorter {
    private LegacySorter legacy;

    public SorterAdapter() {
        this.legacy = new LegacySorter();
    }

    @Override
    public int[] sort(int[] arr) {
        return legacy.quicksort(arr);
    }
    
}
