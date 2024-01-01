const arr = [9, 3, 1, 4, 2, 5, 7, 6, 8, 19, 15];

for (const num of arr) {
  setTimeout(() => console.log(num), num);
}
