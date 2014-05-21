require './sort'

class InsertionSort < Sort
  def sort(input)
    input.each_index do |i|
      (0..i).each do |j|
          swap input, i, j if input[i] < input[j]
      end
    end
  end

end

print InsertionSort.new.sort [8, 1, 6, 5, 2, 9, 0, 4]