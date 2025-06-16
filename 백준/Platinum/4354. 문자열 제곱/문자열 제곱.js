const fs = require('fs');
const [...input] = fs.readFileSync('/dev/stdin').toString().trim().split("\n");
//const [...input] = fs.readFileSync("input.txt").toString().trim().split("\n");

function stringPower(s) {
  const n = s.length;
  const lps = new Array(n).fill(0);

  // LPS 배열 생성
  let len = 0;
  for (let i = 1; i < n; ) {
    if (s[i] === s[len]) {
      len++;
      lps[i] = len;
      i++;
    } else {
      if (len !== 0) {
        len = lps[len - 1];
      } else {
        lps[i] = 0;
        i++;
      }
    }
  }

  const longestPrefixSuffix = lps[n - 1];
  const patternLength = n - longestPrefixSuffix;

  if (n % patternLength === 0) {
    return n / patternLength;
  } else {
    return 1;
  }
}

for (let i=0;i<input.length-1;i++) {
  console.log(stringPower(input[i]));
}
