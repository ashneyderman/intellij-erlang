/*
 * Copyright 2012 Sergey Ignatov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.erlang.psi.impl;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ArrayUtil;
import com.intellij.util.containers.ContainerUtil;
import org.intellij.erlang.psi.ErlangFile;
import org.intellij.erlang.psi.ErlangFunction;
import org.intellij.erlang.psi.ErlangQAtom;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ignatov
 */
public class ErlangFunctionReferenceImpl<T extends ErlangQAtom> extends ErlangAtomBasedReferenceImpl<T> {
  @Nullable
  private final ErlangQAtom myModuleAtom;
  private final int myArity;

  public ErlangFunctionReferenceImpl(@NotNull T element, @Nullable ErlangQAtom moduleAtom, TextRange range, String name, int arity) {
    super(element, range, name);
    myModuleAtom = moduleAtom;
    myArity = arity;
  }

  @Override
  public PsiElement resolve() {
    if (myModuleAtom != null) {
      return getExternalFunction(myModuleAtom.getText() + ".erl");
    }

    PsiFile containingFile = myElement.getContainingFile();
    return containingFile instanceof ErlangFile ? ((ErlangFile) containingFile).getFunction(myReferenceName, myArity) : null;
  }

  @Nullable
  private ErlangFunction getExternalFunction(@NotNull String moduleFileName) {
    PsiFile[] files = FilenameIndex.getFilesByName(myElement.getProject(), moduleFileName,
      GlobalSearchScope.allScope(myElement.getProject())); // todo: use module scope
    List<ErlangFunction> result = new ArrayList<ErlangFunction>();
    for (PsiFile file : files) {
      if (file instanceof ErlangFile) {
        result.add(((ErlangFile) file).getFunction(myReferenceName, myArity));
      }
    }
    return ContainerUtil.getFirstItem(result);
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    List<LookupElement> lookupElements = ErlangPsiImplUtil.getFunctionLookupElements(myElement.getContainingFile(), true, null);
    return ArrayUtil.toObjectArray(lookupElements);
  }
}
