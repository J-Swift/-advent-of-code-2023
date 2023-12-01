(require '[clojure.string :as str])

(defn loadInput []
  (slurp "input.txt"))

(defn parseInput [input]
 (str/split input #"\n"))

(defn get-first-number [s]
  (Integer/parseInt (str (first (re-find #"\d" s)))))

(defn get-value [line]
  (let [n1 (get-first-number line)
        n2 (get-first-number (str/reverse line))]
    (+ (* n1 10) n2)))

(defn main []
  (let [input (parseInput (loadInput))]
    (->> input
      (map get-value)
      (reduce +)
      println)
    ))

(main)
