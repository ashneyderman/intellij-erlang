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

public class ErlangCrClauseImpl extends ErlangCompositeElementImpl implements ErlangCrClause {

  public ErlangCrClauseImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public ErlangArgumentDefinition getArgumentDefinition() {
    return findNotNullChildByClass(ErlangArgumentDefinition.class);
  }

  @Override
  @NotNull
  public ErlangClauseBody getClauseBody() {
    return findNotNullChildByClass(ErlangClauseBody.class);
  }

  @Override
  @Nullable
  public ErlangClauseGuard getClauseGuard() {
    return findChildByClass(ErlangClauseGuard.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitCrClause(this);
    else super.accept(visitor);
  }

}
