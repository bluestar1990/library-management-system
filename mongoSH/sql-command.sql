

Tạo index để tăng tốc tìm kiếm

db.books.createIndex({ "isbn": 1 }, { unique: true })
db.books.createIndex({ "title": 1 })
db.books.createIndex({ "author_ids": 1 })
db.authors.createIndex({ "name": 1 })
db.publishers.createIndex({ "name": 1 })
db.categories.createIndex({ "name": 1 })
========================================================================== Một số lệnh cho Sách ==================================================

db.books.insertMany([
	{ 
		title: "Tender Is the Night", 
		author_ids: [ObjectId("66b393c20fedba3fab70a14c"),ObjectId("66b393c20fedba3fab70a14e") ],
		publisher_id: ObjectId("66b393c20fedba3fab70a154"),
		category_ids: [ObjectId("66b393c20fedba3fab70a159"),ObjectId("66b393c20fedba3fab70a15c") ],
		isbn: "97809665169751234567892",
		published_date: "2024-10-12T00:00:00.000",
		copies: 21
	},
	{ 
		title: "Unweaving the Rainbow", 
		author_ids: [ObjectId("66b393c20fedba3fab70a14c"),ObjectId("66b393c20fedba3fab70a14e") ],
		publisher_id: ObjectId("66b393c20fedba3fab70a154"),
		category_ids: [ObjectId("66b393c20fedba3fab70a159"),ObjectId("66b393c20fedba3fab70a15c") ],
		isbn: "97809665169751234567893",
		published_date: "2024-10-12T00:00:00.000",
		copies: 31
	}
]);

db.books.updateOne(
    { _id: ObjectId("66b3a20122ead978a95639e1") },  // Filter by _id
    { 
        $set: { 
            title: "Updated Book Title", 
            isbn: "9781449331818",
            published_date: new Date("2024-10-12"),
            copies: 100
        }
    }
)


Xóa Sách bằng ObjectId
db.books.deleteMany({
  _id: { 
    $in: [
      ObjectId("66b3822d11e92a3a60f91065")
    ]
  }
});

Một số Command tìm kiếm Sách bằng title
db.books.findOne({title: "phucvv3"})
db.books.find({ title: "Tender Is the Night" }).pretty()
db.books.find({}, { _id: 1 })

Đây là lệnh để tổng hợp dữ liệu bào gồm cả tìm kiếm và sắp xếp
========== Tìm kiếm và sắp xếp theo Tác Giả
db.books.aggregate(
[
  {
    "$lookup": {
      "from": "categories",
      "localField": "category_ids",
      "foreignField": "_id",
      "as": "category_details"
    }
  },
  {
    "$lookup": {
      "from": "authors",
      "localField": "author_ids",
      "foreignField": "_id",
      "as": "author_details"
    }
  },
  {
    "$lookup": {
      "from": "publishers",
      "localField": "publisher_id",
      "foreignField": "_id",
      "as": "publisher_details"
    }
  },
  {
    "$unwind": {
      "path": "$publisher_details",
      "preserveNullAndEmptyArrays": true
    }
  },
    {
	$match: {
		"author_details.name": { $regex: /John Doe 9/, $options: 'i' }
	}
  },
  {
    $sort: {
      "published_date": -1
    }
  },
  {
    "$project": {
      "_id": 1,
      "title": 1,
      "isbn": 1,
      "published_date": 1,
      "copies": 1,
      "categoryName": "$category_details.name",
      "authorNames": "author_details.name",
      "publisherName": "$publisher_details.name"
    }
  }
]);


====
db.books.aggregate(
[
  {
    "$lookup": {
      "from": "categories",
      "localField": "category_ids",
      "foreignField": "_id",
      "as": "category_details"
    }
  },
  {
    "$lookup": {
      "from": "authors",
      "localField": "author_ids",
      "foreignField": "_id",
      "as": "author_details"
    }
  },
  {
    "$lookup": {
      "from": "publishers",
      "localField": "publisher_id",
      "foreignField": "_id",
      "as": "publisher_details"
    }
  },
  {
    "$unwind": {
      "path": "$publisher_details",
      "preserveNullAndEmptyArrays": true
    }
  },
    {
	$match: {
		"category_details.name": { $regex: /Science/, $options: 'i' }
	}
  },
  {
    $sort: {
      "published_date": 1
    }
  },
  {
    "$project": {
      "_id": 1,
      "title": 1,
      "isbn": 1,
      "published_date": 1,
      "copies": 1,
      "categoryName": "$category_details.name",
      "authorNames": "$author_details.name",
      "publisherName": "$publisher_details.name"
    }
  }
]);

Ví dụ thêm 1 số match để tìm kiếm bằng author name và mã isbn
$match: {
	"author_details.name": { $regex: /William Shakespeare 4/, $options: 'i' }
}
$match: {
	"isbn": { $regex: /9/, $options: 'i' }
}


