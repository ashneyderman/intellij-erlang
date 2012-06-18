// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ErlangType extends ErlangCompositeElement {

  @Nullable
  ErlangBinaryType getBinaryType();

  @Nullable
  ErlangFieldTypes getFieldTypes();

  @Nullable
  ErlangFunType100T getFunType100T();

  @Nullable
  ErlangIntType getIntType();

  @NotNull
  List<ErlangQAtom> getQAtomList();

  @Nullable
  ErlangQVar getQVar();

  @Nullable
  ErlangTopType getTopType();

  @Nullable
  ErlangTopTypes getTopTypes();

  @Nullable
  PsiElement getFun();

}