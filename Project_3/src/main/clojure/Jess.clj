(ns Jess)
(defn append [lizt1 lizt2]
  (cond
    (empty? lizt1) lizt2
    
    :else (cons (first lizt1)
      (append (rest lizt1) lizt2))
  )
)

(defn same [lizt1 lizt2]
  (cond
    (empty? lizt1) (empty? lizt2)
    (empty? lizt2) false

    (= (first lizt1) (first lizt2))
      (same (rest lizt1) (rest lizt2))

    :else false
  )
)
