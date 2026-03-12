package com.corecue.fitness.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0014\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/corecue/fitness/ui/home/ExerciseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/corecue/fitness/ui/home/ExerciseAdapter$ExerciseVH;", "onStart", "Lkotlin/Function1;", "Lcom/corecue/fitness/data/model/Exercise;", "", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "newItems", "", "ExerciseVH", "app_debug"})
public final class ExerciseAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.corecue.fitness.ui.home.ExerciseAdapter.ExerciseVH> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.corecue.fitness.data.model.Exercise, kotlin.Unit> onStart = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.corecue.fitness.data.model.Exercise> items = null;
    
    public ExerciseAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.corecue.fitness.data.model.Exercise, kotlin.Unit> onStart) {
        super();
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.corecue.fitness.data.model.Exercise> newItems) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.corecue.fitness.ui.home.ExerciseAdapter.ExerciseVH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.corecue.fitness.ui.home.ExerciseAdapter.ExerciseVH holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/corecue/fitness/ui/home/ExerciseAdapter$ExerciseVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/corecue/fitness/databinding/ItemExerciseBinding;", "(Lcom/corecue/fitness/ui/home/ExerciseAdapter;Lcom/corecue/fitness/databinding/ItemExerciseBinding;)V", "bind", "", "item", "Lcom/corecue/fitness/data/model/Exercise;", "app_debug"})
    public final class ExerciseVH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.corecue.fitness.databinding.ItemExerciseBinding binding = null;
        
        public ExerciseVH(@org.jetbrains.annotations.NotNull()
        com.corecue.fitness.databinding.ItemExerciseBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.corecue.fitness.data.model.Exercise item) {
        }
    }
}