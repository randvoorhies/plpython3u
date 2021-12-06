package com.github.randvoorhies.plpython3u;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.impl.PsiTreeChangePreprocessor;
import org.jetbrains.annotations.NotNull;

public class PLPythonTreeChangePreprocessor implements PsiTreeChangePreprocessor {
    @Override
    public void treeChanged(@NotNull PsiTreeChangeEventImpl psiTreeChangeEvent) {
        // I dunno maybe I should be using this thing?
    }
}
