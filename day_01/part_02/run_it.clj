(require '[clojure.string :as str])

(defn loadInput []
  (slurp "input.txt"))

(defn parseInput [input]
 (str/split input #"\n"))

(defn get-first-numberish [s]
  (str (re-find #"\d|one|two|three|four|five|six|seven|eight|nine" s)))

(defn get-last-numberish [s]
  (str/reverse (str (re-find #"\d|enin|thgie|neves|xis|evif|ruof|eerht|owt|eno" (str/reverse s)))))

(defn to-number [numberish]
  (case numberish
    "one" 1
    "two" 2
    "three" 3
    "four" 4
    "five" 5
    "six" 6
    "seven" 7
    "eight" 8
    "nine" 9
    (Integer/parseInt (str numberish))))

(defn get-value [line]
  (let [ n1 (to-number (get-first-numberish line))
        n2 (to-number (get-last-numberish line))]
    (+ (* n1 10) n2)))

(defn main []
  (let [input (parseInput (loadInput))]
    (->> input
      (map get-value)
      (reduce +)
      println)
    ))

(main)
