(ns clj-return-from.core
  (:use clojure.tools.macro))

(defn return-from* [name thread expr]
  (if (not= (Thread/currentThread) thread)
    (throw (Exception. "Attempt to return-from in a different thread than the one that established the block."))
    (throw (com.adknife.NonLocalExit. name expr)))
  )

(defmacro block [name & body]
  (let [block-id (gensym)]
    `(let [block-thread# (Thread/currentThread)]
       (macrolet [(~(symbol (str "return-from-" name)) [expr#]
                   (list 'return-from* (quote (quote ~block-id)) (quote block-thread#) expr#))]
                 (try ~@body
                      (catch com.adknife.NonLocalExit e#
                        (if (not= '~block-id (.getBlockName e#))
                          (throw e#))
                        (.getResult e#)))))))

