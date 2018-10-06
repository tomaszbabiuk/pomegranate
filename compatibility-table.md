# Espresso <-> Jack-knife compatibility table
| Espresso                                  | Jack-knife                                            |
| ----------------------------------------- | ----------------------------------------------------- |
| withAlpha(float)                          | @WithAlpha(float)                                     |
| withContentDescription(String)            | @WithContentDescription(String)                       |
| withContentDescription(@StringRes int)    | @WithContentDescription(fromResource = @StringRes)    |
| withContentDescription(Matcher<String>)   | [use custom matcher](use-custom-matcher.md)           |
| withChild(Matcher<View>)                  | [use custom matcher](use-custom-matcher.md)           |                                   
| withClassName(Matcher<String>)            | [use custom matcher](use-custom-matcher.md)           |
| withEffectiveVisibility(Visibility)       | @WithEffectiveVisibility(Visibility)                  |
| withHint(int)                             | @WithHint(@StringRes int)                             |
| withHint(String hintText)                 | @WithHint(String)                                     |
| withHint(Matcher<String>)                 | [use custom matcher](use-custom-matcher.md)           |
| withId(int)                               | @WithId(@ResId id)                                    |
| withId(Matcher<Integer>)                  | [use custom matcher](use-custom-matcher.md)           |
| withInputType(int)                        | not supported (*)                                     |
| withResourceName(String)                  | not supported (*)                                     |
| withResourceName(Matcher<String>)         | [use custom matcher](use-custom-matcher.md)           |
| withSpinnerText(int)                      | not supported (*)                                     |
| withSpinnerText(Matcher<String>)          | [use custom matcher](use-custom-matcher.md)           |
| withSpinnerText(String)                   | not supported (*)                                     |
| withSubstring(String)                     | not supported (*)                                     |
| withTagKey(int)                           | @WithTagKey(int)                                      |
| withTagKey(int, Matcher<Object>)          | [use custom matcher](use-custom-matcher.md)           |
| withTagValue(Matcher<Object>)             | [use custom matcher](use-custom-matcher.md)           |
| withText(String)                          | @WithText(String)                                     |
| withText(int)                             | @WithText(fromResource = @StringRes)                  |
| withText(Matcher<String>)                 | [use custom matcher](use-custom-matcher.md)           |
| withParentIndex(int)                      | not supported (*)                                     |
| withParent(Matcher<View>)                 | [use custom matcher](use-custom-matcher.md)           |
| isAssignableFrom(Class)                   | @IsAssignableFrom(Class)                              |
| isDisplayed()                             | not supported (*)                                     |
| isChecked()                               | not supported (*)                                     |
| isClickable()                             | not supported (*)                                     |
| isCompletelyDisplayed()                   | not supported (*)                                     |
| isDisplayingAtLeast(int)                  | not supported (*)                                     |
| isDescendantOfA(int)                      | @IsDescendantOfA(@ResId int)                          |
| isDescendantOfA(Matcher<View>)            | [use custom matcher](use-custom-matcher.md)           |
| isEnabled()                               | not supported (*)                                     |
| isFocusable()                             | not supported (*)                                     |
| isJavascriptEnabled()                     | not supported (*)                                     |
| isNotChecked()                            | not supported (*)                                     |       
| isRoot()                                  | not supported (*)                                     |
| isSelected()                              | not supported (*)                                     |
| hasBackground(int)                        | not supported (*)                                     |
| hasChildCount(int)                        | not supported (*)                                     |
| hasContentDescription()                   | not supported (*)                                     |
| hasDescendant(Matcher<View>)              | [use custom matcher](use-custom-matcher.md)           |
| hasErrorText(Matcher<String>)             | [use custom matcher](use-custom-matcher.md)           |
| hasErrorText(String)                      | not supported (*)                                     |
| hasFocus()                                | not supported (*)                                     |
| hasImeAction(int)                         | not supported (*)                                     |
| hasImeAction(Matcher<Integer>)            | [use custom matcher](use-custom-matcher.md)           |
| hasLinks()                                | not supported (*)                                     |
| hasMinimumChildCount(int)                 | not supported (*)                                     |
| hasSibling(Matcher<View>)                 | [use custom matcher](use-custom-matcher.md)           |
| hasTextColor(int)                         | not supported (*)                                     |
| assertThat(T, Matcher<T>)                 | This approach is against Page Object Model pattern.   |
| assertThat(String, T, Matcher<T>)         | This approach is against Page Object Model pattern.   |
| supportsInputMethods()                    | not supported (*)                                     |
