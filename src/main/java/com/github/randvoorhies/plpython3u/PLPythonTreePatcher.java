package com.github.randvoorhies.plpython3u;

import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.templateLanguages.OuterLanguageElement;
import com.intellij.psi.templateLanguages.TreePatcher;
import com.intellij.util.CharTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PLPythonTreePatcher implements TreePatcher {
    @Override
    public void insert(@NotNull CompositeElement compositeElement, @Nullable TreeElement treeElement, @NotNull OuterLanguageElement outerLanguageElement) {
        // Or maybe this is the right way to go - I have no idea.
    }

    @Override
    public @NotNull LeafElement split(@NotNull LeafElement leaf, int offset, @NotNull CharTable table) {
        return TreePatcher.super.split(leaf, offset, table);
    }
}
