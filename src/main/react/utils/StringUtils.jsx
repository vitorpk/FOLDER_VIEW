export function append(str, condition, text) {
    if (!text)
        return;
    if (str === undefined)
    str = '';
    if (condition) {
      if (str)
      str = str + ' ' + text;
      else
      str = text;
    }
    
    return str;
}

export function isEmpty(str) {
  return str === undefined || str === null || str === '';
}

export function isNotEmpty(str) {
  return str !== undefined && str !== null && str !== '';
}