package com.github.randvoorhies.plpython3u;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiPlainTextFile;
import org.jetbrains.annotations.NotNull;
// import com.jetbrains.python.*;
// import com.jetbrains.python.psi.PyAssignmentStatement;

public class DemoInspectionVisitor extends PsiElementVisitor {
    @Override
    public void visitElement(@NotNull PsiElement element) {
        PsiElement context = element.getContext();
        PsiElement parent = element.getContext().getParent();
        PsiElement grandParent = parent.getParent();
        // If we are a Python statement, and our grandparent is a PostgreSQL statement,
        // then it looks like we're part of an injection of Python into PostgreSQL
        if(grandParent.getLanguage().getDisplayName().equals("PostgreSQL") && grandParent.toString() == "SQL_CREATE_FUNCTION_STATEMENT") {
            // Look through our grandparent and see if we can find a SQL_PARAMETER_LIST in there
            PsiElement[] functionDefinition = grandParent.getChildren();
            for (PsiElement functionDefinitionElement : functionDefinition) {
                if (functionDefinitionElement.toString().equals("SQL_PARAMETER_LIST")) {

                    // Nice - we found our SQL_PARAMETER_LIST. Now lets just loop over the contents
                    // to find the SQL_PARAMETER_DEFINITIONs so we can pull out the parameter names and types
                    for (PsiElement functionParameter : functionDefinitionElement.getChildren()) {
                        if (functionParameter.toString().equals("SQL_PARAMETER_DEFINITION")) {
                            var variableName = functionParameter.getChildren()[0].getText();
                            var variableType = functionParameter.getChildren()[1].getText();

                            // TODO: Ok, so now how do I insert the detected parameters into the current element?
                        }
                    }
                }
            }
        }
        super.visitElement(element);
    }

    @Override
    public void visitPlainTextFile(@NotNull PsiPlainTextFile file) {
        super.visitPlainTextFile(file);
    }
}
