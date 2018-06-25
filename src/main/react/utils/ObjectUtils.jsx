export function isNull(obj) {
    return (obj === null || obj === undefined);
}

export function isInvalid(value, required, regexp) {
  let invalid = false;
  if (required && !value)
    invalid = true;
  else if (regexp) {
    const reg = new RegExp(regexp);
    invalid = !reg.test(value);
  }

  return invalid;
}