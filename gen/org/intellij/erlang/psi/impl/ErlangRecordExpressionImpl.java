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
import com.intellij.psi.PsiReference;

public class ErlangRecordExpressionImpl extends ErlangExpressionImpl implements ErlangRecordExpression {

  public ErlangRecordExpressionImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public ErlangExpression getExpression() {
    return findChildByClass(ErlangExpression.class);
  }

  @Override
  @NotNull
  public List<ErlangQAtom> getQAtomList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangQAtom.class);
  }

  @Override
  @Nullable
  public ErlangQVar getQVar() {
    return findChildByClass(ErlangQVar.class);
  }

  @Override
  @Nullable
  public ErlangRecordTuple getRecordTuple() {
    return findChildByClass(ErlangRecordTuple.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitRecordExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangQAtom getAtomName() {
    List<ErlangQAtom> p1 = getQAtomList();
    return p1.size() < 1 ? null : p1.get(0);
  }

  @Nullable
  public PsiReference getReference() {
    return ErlangPsiImplUtil.getReference(this);
  }

}
