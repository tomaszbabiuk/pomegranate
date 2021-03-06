# Espresso & Jack-knife compatibility table
| Espresso                                  | Jack-knife                                            |
| ----------------------------------------- | ----------------------------------------------------- |
| withAlpha(float)                          | @WithAlpha(float)                                     |
| withContentDescription(String)            | @WithContentDescription(String)                       |
| withContentDescription(@StringRes int)    | @WithContentDescription(fromResource = @StringRes)    |
| withContentDescription(Matcher<String>)   | [use custom matcher](use-custom-matcher.md)           |
| withChild(Matcher<View>)                  | [use custom matcher](use-custom-matcher.md)           |                                   
| withClassName(Matcher<String>)            | [use custom matcher](use-custom-matcher.md)           |
| withEffectiveVisibility(Visibility)       | @WithEffectiveVisibility(Visibility)                  |
| withHint(int)                             | @WithHint(fromResource = @StringRes)                  |
| withHint(String hintText)                 | @WithHint(String)                                     |
| withHint(Matcher<String>)                 | [use custom matcher](use-custom-matcher.md)           |
| withId(int)                               | @WithId(@ResId int)                                   |
| withId(Matcher<Integer>)                  | [use custom matcher](use-custom-matcher.md)           |
| withInputType(int)                        | @WithInputType(int)                                   |
| withResourceName(String)                  | @WithResourceName(String)                             |
| withResourceName(Matcher<String>)         | [use custom matcher](use-custom-matcher.md)           |
| withSpinnerText(int)                      | @WithSpinnerText(@StringRes int)                      |
| withSpinnerText(String)                   | @WithSpinnerText(String)                              |
| withSpinnerText(Matcher<String>)          | [use custom matcher](use-custom-matcher.md)           |
| withSubstring(String)                     | @WithSubstring(String)                                |
| withTagKey(int)                           | @WithTagKey(int)                                      |
| withTagKey(int, Matcher<Object>)          | [use custom matcher](use-custom-matcher.md)           |
| withTagValue(Matcher<Object>)             | [use custom matcher](use-custom-matcher.md)           |
| withText(String)                          | @WithText(String)                                     |
| withText(int)                             | @WithText(fromResource = @StringRes)                  |
| withText(Matcher<String>)                 | [use custom matcher](use-custom-matcher.md)           |
| withParentIndex(int)                      | @WithParentIndex(int)                                 |
| withParent(Matcher<View>)                 | [use custom matcher](use-custom-matcher.md)           |
| isAssignableFrom(Class)                   | @IsAssignableFrom(Class)                              |
| isChecked()                               | @IsChecked()                                          |
| isDisplayed()                             | @IsDisplayed()                                        |
| isClickable()                             | @IsClickable()                                        |
| isCompletelyDisplayed()                   | @IsCompletelyDisplayed()                              |
| isDisplayingAtLeast(int)                  | @IsDisplayingAtLeast(int)                             |
| isDescendantOfA(int)                      | @IsDescendantOfA(@ResId int)                          |
| isDescendantOfA(Matcher<View>)            | [use custom matcher](use-custom-matcher.md)           |
| isEnabled()                               | @IsEnabled()                                          |
| isFocusable()                             | @IsFocusable()                                        |
| isJavascriptEnabled()                     | @IsJavascriptEnabled()                                |
| isNotChecked()                            | @IsNotChecked()                                       |       
| isRoot()                                  | @IsRoot()                                             |
| isSelected()                              | @IsSelected()                                         |
| hasBackground(int)                        | @HasBackground(@DrawableRes int)                      |
| hasChildCount(int)                        | @HasChildCount(int)                                   |
| hasContentDescription()                   | @HasContentDescription()                              |
| hasDescendant(Matcher<View>)              | [use custom matcher](use-custom-matcher.md)           |
| hasErrorText(Matcher<String>)             | [use custom matcher](use-custom-matcher.md)           |
| hasErrorText(String)                      | @HasErrorText(String)                                 |
| n/a                                       | @HasErrorText(fromResource = @StringRes)              |
| hasFocus()                                | @HasFocus()                                           |
| hasImeAction(int)                         | @HasImeAction(int)                                    |
| hasImeAction(Matcher<Integer>)            | [use custom matcher](use-custom-matcher.md)           |
| hasLinks()                                | @HasLinks()                                           |
| hasMinimumChildCount(int)                 | @HasMinimumChildCount(int)                            |
| hasSibling(Matcher<View>)                 | [use custom matcher](use-custom-matcher.md)           |
| hasTextColor(int)                         | @HasTextColor(@ColorRes int)                          |
| assertThat(T, Matcher<T>)                 | This approach is against Page Object Model pattern.   |
| assertThat(String, T, Matcher<T>)         | This approach is against Page Object Model pattern.   |
| supportsInputMethods()                    | @SupportsInputMethods()                               |
