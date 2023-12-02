(require '[clojure.string :as str])

(defn load-input []
  (slurp "input.txt"))

(defn parse-input [input]
 (str/split input #"\n"))

;; Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
;; {:game-num 1, :game-rest {:red 4, :green 2, :blue 6}}
(defn parse-game [game-str]
  (let [game-parts (re-find #"Game (\d+): (.+)" game-str)
        game-num (Integer/parseInt (get game-parts 1))
        color-counts (map #(hash-map (keyword (get % 2)) (Integer/parseInt (get % 1))) (re-seq #"(\d+) (red|green|blue)" (get game-parts 2)))
        game-rest (reduce #(merge-with max %1 %2) {:red 0 :green 0 :blue 0} color-counts)]
    {:game-num game-num
     :game-rest game-rest}))

(defn get-total [game]
  (* 
    (get-in game [:game-rest :red])
    (get-in game [:game-rest :green])
    (get-in game [:game-rest :blue])))

(defn main []
  (let [input (parse-input (load-input))
        target {:red 12 :green 13 :blue 14}]
    (->> input
      (map parse-game)
      (map get-total)
      (reduce +)
      println)
    ))

(main)
