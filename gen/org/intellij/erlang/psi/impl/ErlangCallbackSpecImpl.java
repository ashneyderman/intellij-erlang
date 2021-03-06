// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.erlang.ErlangTypes.*;
import org.intellij.erlang.psi.*;

public class ErlangCallbackSpecImpl extends ErlangCompositeElementImpl implements ErlangCallbackSpec {

  public ErlangCallbackSpecImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public ErlangTypeSpec getTypeSpec() {
    return findChildByClass(ErlangTypeSpec.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitCallbackSpec(this);
    else super.accept(visitor);
  }

}
