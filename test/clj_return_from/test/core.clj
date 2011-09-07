(ns clj-return-from.test.core
  (:use clj-return-from.core clojure.test))

(defn nested-fn-call [closure]
  (block x
         (closure)))

(deftest return-from-tests
  (is (block foo
             (+ 1 2))
      3)

  (is (block foo
             (return-from-foo :bar)
             (+ 1 2))
      :bar)

  (is (block foo
             (loop []
               (return-from-foo :bar)
               (recur)))
      :bar)

  ;; make sure the blocks are really treated lexically. If they were
  ;; dynamic, the expression below would evaluate to :bar
  (is (block x
             (nested-fn-call (fn [] (return-from-x :foo)))
             :bar)
      :foo)
  )
