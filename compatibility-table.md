# Espresso <-> Jack-knife compatibility table
| Espresso                                  | Jack-knife        |
| ----------------------------------------- |-------------------|
| withAlpha(float)                          | @WithAlpha(float) |
| withContentDescription(String)            | not supported (*) |
| withContentDescription(@StringRes int)    | @WithText(fromResource = @StringRes) |
| withContentDescription(Matcher<String>)   | not supported (*) |
| withChild(Matcher<View>)                  | not supported (*) |
| withClassName(Matcher<String>)            | not supported (*) |
| withEffectiveVisibility(Visibility)       | not supported (*) |
| withHint(String hintText)                 | not supported (*) |
| withHint(Matcher<String>)                 | not supported (*) |
| withHint(int)                             | not supported (*) |
| withId(int)                               | @WithId(@ResId id) |
| withId(Matcher<Integer>)                  | not supported (*) |
| withInputType(int)                        | not supported (*) |
| withResourceName(String)                  | not supported (*) |
| withResourceName(Matcher<String>)         | not supported (*) |
| withSpinnerText(int)                      | not supported (*) |
| withSpinnerText(Matcher<String>)          | not supported (*) |
| withSpinnerText(String)                   | not supported (*) |
| withSubstring(String)                     | not supported (*) |
| withTagKey(int)                           | @WithTagKey(int) |
| withTagKey(int, Matcher<Object>)          | not supported (*) |
| withTagValue(Matcher<Object>)             | not supported (*) |
| withText(String)                          | @WithText(String) |
| withText(int)                             | @WithText(fromResource = @StringRes) |
| withText(Matcher<String>)                 | not supported (*) |
| withParentIndex(int)                      | not supported (*) |
| withParent(Matcher<View>)                 | not supported (*) |
| isAssignableFrom(Class)                   | @IsAssignableFrom(Class) |
| isDisplayed()                             | not supported (*) |
| isChecked()                               | not supported (*) |
| isClickable()                             | not supported (*) |
| isCompletelyDisplayed()                   | not supported (*) |
| isDisplayingAtLeast(int)                  | not supported (*) |
| isDescendantOfA(int)                      | @IsDescendantOfA(@ResId int) |
| isDescendantOfA(Matcher<View>)            | not supported (*) |
| isEnabled()                               | not supported (*) |
| isFocusable()                             | not supported (*) |
| isJavascriptEnabled()                     | not supported (*) |
| isNotChecked()                            | not supported (*) |
| isRoot()                                  | not supported (*) |
| isSelected()                              | not supported (*) |
| hasBackground(int)                        | not supported (*) |
| hasChildCount(int)                        | not supported (*) |
| hasContentDescription()                   | not supported (*) |
| hasDescendant(Matcher<View>)              | not supported (*) |
| hasErrorText(Matcher<String>)             | not supported (*) |
| hasErrorText(String)                      | not supported (*) |
| hasFocus()                                | not supported (*) |
| hasImeAction(int)                         | not supported (*) |
| hasImeAction(Matcher<Integer>)            | not supported (*) |
| hasLinks()                                | not supported (*) |
| hasMinimumChildCount(int)                 | not supported (*) |
| hasSibling(Matcher<View>)                 | not supported (*) |
| hasTextColor(int)                         | not supported (*) |
| assertThat(T, Matcher<T>)                 | not supported (*) |
| assertThat(String, T, Matcher<T>)         | not supported (*) |
| supportsInputMethods()                    | not supported (*) |
